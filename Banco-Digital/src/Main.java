public class Main {
    public static void main(String[] args) {
        Conta contaCorrente = new ContaCorrente();
        Conta contaPoupanca = new ContaPoupanca();

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();


        contaCorrente.depositar(400);
        contaCorrente.imprimirExtrato();
        contaCorrente.transferir(100, contaPoupanca);
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}
