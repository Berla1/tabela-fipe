package com.example.TabelaFipe.main;

import com.example.TabelaFipe.model.DadosModelos;
import com.example.TabelaFipe.model.DadosVeiculo;
import com.example.TabelaFipe.model.DetalhesVeiculo;
import com.example.TabelaFipe.service.ConnectionApi;
import com.example.TabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConnectionApi conn = new ConnectionApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {


        System.out.println("*** OPÇÕES ***\nCarros\nMotos\nCaminhões");
        System.out.print("Digite uma das opções para consultar os valores: ");
        String opcaoModelo = scanner.next().toLowerCase();

        //pesquisa todos os modelos na API
        var json = conn.obterDados(URL_BASE + opcaoModelo + "/marcas");
        //converte esses dados para lista
        var marcas = conversor.obterLista(json, DadosVeiculo.class);

        marcas.stream()
                .sorted(Comparator.comparing(DadosVeiculo::codigo))
                .forEach(System.out::println);

        System.out.print("Digite o código da marca para consulta: ");
        String opcaoMarcas = scanner.next();

        json = conn.obterDados(URL_BASE + opcaoModelo + "/marcas/" + opcaoMarcas + "/modelos");
        var modelosLista = conversor.obterDados(json, DadosModelos.class);

        System.out.println("\nModelos desta marca: ");

        modelosLista.modelos().stream()
                .sorted(Comparator.comparing(DadosVeiculo::codigo))
                .forEach(System.out::println);

        System.out.print("\nDigite o código para uma consulta dos anos e modelos do veículo: ");
        String opcaoAnos = scanner.next();

        json = conn.obterDados(URL_BASE + opcaoModelo + "/marcas/" + opcaoMarcas + "/modelos/" + opcaoAnos + "/anos");
        List<DadosVeiculo> anos = conversor.obterLista(json, DadosVeiculo.class);
        List<DetalhesVeiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            json = conn.obterDados(URL_BASE + opcaoModelo + "/marcas/" + opcaoMarcas + "/modelos/" + opcaoAnos + "/anos/" + anos.get(i).codigo());
            DetalhesVeiculo detalhes = conversor.obterDados(json, DetalhesVeiculo.class);
            veiculos.add(detalhes);
        }
        System.out.println("Todos os veículos do modelo escolhido filtrado por ano!\n");
        veiculos.forEach(System.out::println);
    }
}
