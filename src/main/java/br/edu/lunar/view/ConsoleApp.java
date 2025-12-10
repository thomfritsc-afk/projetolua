package br.edu.lunar.view;

import br.edu.lunar.model.*;
import br.edu.lunar.service.MissaoService;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleApp {

    private static final Scanner scan = new Scanner(System.in);
    private static final MissaoService service = new MissaoService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== SISTEMA DE MISSÕES LUNARES ====");
            System.out.println("1 - Registrar missão");
            System.out.println("2 - Listar missões");
            System.out.println("3 - Adicionar astronauta");
            System.out.println("4 - Registrar resultado científico");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            int op = Integer.parseInt(scan.nextLine());

            try {

                switch (op) {
                    case 1 -> criarMissao();
                    case 2 -> listar();
                    case 3 -> addAstronauta();
                    case 4 -> registrarResultado();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opção inválida.");
                }

            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }

    private static void criarMissao() {
        System.out.print("Código: ");
        String codigo = scan.nextLine();

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.print("Data lançamento (AAAA-MM-DD): ");
        LocalDate lanc = LocalDate.parse(scan.nextLine());

        System.out.print("Data retorno (AAAA-MM-DD): ");
        LocalDate ret = LocalDate.parse(scan.nextLine());

        System.out.print("Destino: ");
        String destino = scan.nextLine();

        System.out.print("Objetivo: ");
        String obj = scan.nextLine();

        System.out.print("Nome da nave: ");
        String nomeNave = scan.nextLine();

        System.out.print("Capacidade tripulantes: ");
        int cap = Integer.parseInt(scan.nextLine());

        Nave nave = new NaveTripulada(nomeNave, cap, true);

        Missao m = new Missao(codigo, nome, lanc, ret, destino, obj, nave);

        service.registrarMissao(m);

        System.out.println("Missão registrada!");
    }

    private static void listar() {
        System.out.println("\n=== Missões ===");
        service.listar().forEach(System.out::println);
    }

    private static void addAstronauta() {
        System.out.print("Código da missão: ");
        String codigo = scan.nextLine();

        System.out.print("Nome: ");
        String nome = scan.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scan.nextLine());

        System.out.print("Especialidade: ");
        String esp = scan.nextLine();

        System.out.print("Horas de voo: ");
        int horas = Integer.parseInt(scan.nextLine());

        service.adicionarAstronauta(codigo,
                new Astronauta(nome, idade, esp, horas));

        System.out.println("Astronauta adicionado.");
    }

    private static void registrarResultado() {
        System.out.print("Código da missão: ");
        String codigo = scan.nextLine();

        System.out.print("Resultado científico: ");
        String res = scan.nextLine();

        service.registrarResultado(codigo, res);
        System.out.println("Registrado.");
    }
}
