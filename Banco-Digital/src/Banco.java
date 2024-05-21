import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public void removerConta(Conta conta) {
		this.contas.remove(conta);
	}

	public void imprimirExtratos() {
		System.out.println("=== Extratos do Banco " + nome + " ===");
		contas.forEach(Conta::imprimirExtrato);
	}


	public void imprimirClientes() {
		System.out.println("=== Clientes do Banco " + nome + " ===");
		contas.stream()
				.map(conta -> conta.getCliente().getNome())
				.distinct()
				.forEach(System.out::println);
	}

	public Conta encontrarConta(int numeroConta) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numeroConta) {
				return conta;
			}
		}
		return null; // Retorna null se a conta não for encontrada
	}
}
