/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author luiss
 */
public class GerenciaBanco {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao GerenciaBanco!");
        Pessoa cliente = cadastrarPessoa();
        Conta conta = abrirConta(cliente);
        exibirMenu(conta);
    }

    private static Pessoa cadastrarPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        String CPF = scanner.nextLine();

        return new Pessoa(nome, sobrenome, CPF);
    }

    private static Conta abrirConta(Pessoa cliente) {
        return new Conta(cliente);
    }

    private static void exibirMenu(Conta conta) {
        int opcao = 0;
        do {
            System.out.println("================================");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("9 - Encerrar aplicação");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    exibirSaldo(conta);
                    break;
                case 2:
                    System.out.print("Informe o valor a ser depositado: ");
                    try {
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                        exibirSaldo(conta);
                    } catch (Exception ex) {
                        System.out.println("Não foi possível realizar o depósito! Tente novamente.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o valor a ser sacado: ");
                    try {
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                        exibirSaldo(conta);
                    } catch (SaldoInsuficienteException ex) {
                        System.out.println("Operação Cancelada! Saldo insuficiente para o valor informado.");
                    } catch (Exception ex) {
                        System.out.println("Não foi possível realizar o saque! Tente novamente.");
                    }
                    break;
                case 9:
                    System.out.println("Até mais " + conta.getCliente().getNome() + "!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }
    
    private static void exibirSaldo(Conta conta) {
        System.out.println("Saldo: " + conta.getSaldo());
    }

}
