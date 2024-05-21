public class ContaCorrente extends Conta {
    private static final double TARIFA_SAQUE = 2.50;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        imprimirInfosComuns();
    }
    @Override
    public void sacar(double valor, String senha) {
        if (cliente.validarSenha(senha)) {
            saldo -= valor - TARIFA_SAQUE;
            System.out.println("Tarifa de saque de R$ " + TARIFA_SAQUE + " cobrada com sucesso.");
        } else {
            System.out.println("Senha incorreta. Tarifa de saque não autorizada.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino, String senha) {
        if (cliente.validarSenha(senha)) {
            if (saldo >= valor) {
                saldo -= valor;
                contaDestino.depositar(valor);
                System.out.println("Transferência de R$ " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente. Transferência não autorizada.");
            }
        } else {
            System.out.println("Senha incorreta. Transferência não autorizada.");
        }
    }

    @Override
    public String toString() {
        return "Conta Corrente - Titular: " + cliente.getNome() + ", Agência: " + agencia + ", Número: " + numero;
    }

}
