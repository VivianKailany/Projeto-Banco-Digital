
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Banco banco = new Banco("Banco XYZ");

    public static void main(String[] args) {
        boolean continuarExecucao = true;

        while (continuarExecucao) {
            System.out.println("Selecione o modo de usuário: 'banco' ou 'cliente'");
            String modoUsuario = scanner.nextLine().toLowerCase();

            switch (modoUsuario) {
                case "banco":
                    operacoesBanco();
                    break;
                case "cliente":
                    operacoesCliente();
                    break;
                default:
                    System.out.println("Modo de usuário inválido. Por favor, selecione 'banco' ou 'cliente'.");
                    break;
            }

            System.out.println("Deseja continuar? (s/n)");
            String continuar = scanner.nextLine().toLowerCase();
            continuarExecucao = continuar.equals("s");
        }

        System.out.println("Encerrando o programa. Obrigado por usar nosso sistema.");
    }

    private static void operacoesBanco() {
        System.out.println("Bem-vindo ao modo Banco.");

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Listar contas");
            System.out.println("3. Sair");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;
                case 3:
                    System.out.println("Saindo do modo Banco.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarConta() {

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite o CPF do cliente:");
        String cpfCliente = scanner.nextLine();

        System.out.println("Digite o endereço do cliente:");
        String enderecoCliente = scanner.nextLine();

        System.out.println("Digite o email do cliente:");
        String emailCliente = scanner.nextLine();

        System.out.println("Digite a senha da conta:");
        String senhaCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, emailCliente, senhaCliente);

        // Solicite ao usuário que escolha o tipo de conta
        System.out.println("Escolha o tipo de conta (corrente ou poupanca):");
        String tipoConta = scanner.nextLine();

        // Crie a conta com base no tipo especificado
        if (tipoConta.equalsIgnoreCase("corrente")) {
            Conta conta = new ContaCorrente(cliente);
            banco.adicionarConta(conta);
            System.out.println("Conta corrente criada com sucesso.");
        } else if (tipoConta.equalsIgnoreCase("poupanca")) {
            Conta conta = new ContaPoupanca(cliente);
            banco.adicionarConta(conta);
            System.out.println("Conta poupança criada com sucesso.");
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }

    private static void listarContas() {
        System.out.println("Listando contas:");
        List<Conta> contas = banco.getContas();
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    private static void operacoesCliente() {
        System.out.println("Bem-vindo ao modo Cliente.");
        System.out.println("Digite o número da conta:");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        Conta conta = banco.encontrarConta(numeroConta);

        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Visualizar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Realizar transferência");
            System.out.println("5. Visualizar extrato");
            System.out.println("6. Sair");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = Double.parseDouble(scanner.nextLine());
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a senha da conta:");
                    String senhaSaque = scanner.nextLine();
                    conta.sacar(valorSaque, senhaSaque);
                    break;
                case 4:
                    System.out.println("Digite o número da conta de destino:");
                    int numeroDestino = Integer.parseInt(scanner.nextLine());
                    Conta contaDestino = banco.encontrarConta(numeroDestino);

                    if (contaDestino == null) {
                        System.out.println("Conta de destino não encontrada.");
                        break;
                    }

                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite a senha da conta:");
                    String senhaTransferencia = scanner.nextLine();
                    conta.transferir(valorTransferencia, contaDestino, senhaTransferencia);
                    break;
                case 5:
                    System.out.println("Extrato da conta:");
                    conta.imprimirExtrato();
                    break;
                case 6:
                    System.out.println("Saindo do modo Cliente.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
