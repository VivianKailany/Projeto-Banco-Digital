public class ContaPoupanca extends Conta {

    private static final double LIMITE_SAQUE = 1500.0; // Limite de saque para a conta poupança

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        imprimirInfosComuns();
    }

    public double consultarLimiteSaque() {
        return LIMITE_SAQUE;
    }

    @Override
    public void sacar(double valor, String senha) {
        if (valor <= LIMITE_SAQUE) {
            super.sacar(valor, senha);
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Limite de saque excedido. Saque não autorizado.");
        }
    }

    @Override
    public String toString() {
        return "Conta Poupança - Titular: " + cliente.getNome() + ", Agência: " + agencia + ", Número: " + numero;
    }

}
