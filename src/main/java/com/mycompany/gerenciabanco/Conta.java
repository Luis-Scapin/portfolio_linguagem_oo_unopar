/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciabanco;

/**
 *
 * @author luiss
 */
public class Conta {

    private Pessoa cliente;
    private double saldo;

    public Conta(Pessoa cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException();
        }

        this.saldo -= valor;
    }
}
