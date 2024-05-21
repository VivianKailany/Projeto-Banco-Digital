# Documentação dos Arquivos do Projeto Banco Digital

## Estrutura do Projeto

### Arquivos e Classes

- `Banco.java`
  - **Descrição**: Define a classe `Banco` que gerencia a lista de contas.
  - **Métodos Principais**:
    - `public void adicionarConta(Conta conta)`: Adiciona uma nova conta ao banco.
    - `public void removerConta(Conta conta)`: Remove uma nova conta ao banco.
    - `public Conta encontrarConta(int numeroConta) )`: Encontra uma conta pelo número.
    - `public void imprimirExtratos()`: Imprime os extratos de todas as contas.
    - `public void imprimirClientes()`: Imprime os nomes dos clientes do banco.


  
- `Cliente.java`
  - **Descrição**: Define a classe `Cliente` que representa um cliente do banco.
  - **Atributos**:
    - `private String nome`
    - `private String cpf`
    - `private String endereco`
    - `private String email`
    - `private String senha`
  - **Métodos**:
    - `public boolean validarSenha(String senha)`: Valida a senha do cliente.

- `Conta.java`
  - **Descrição**: Classe abstrata que define métodos e atributos comuns a todas as contas.
  - **Atributos**:
    - `protected int agencia`
    - `protected int numero`
    - `protected double saldo`
    - `protected Cliente cliente`
  - **Métodos**:
    - `public void sacar(double valor, String senha)`: Realiza um saque, validando a senha.
    - `public void depositar(double valor)`: Realiza um depósito.
    - `public void transferir(double valor, IConta contaDestino, String senha)`: Realiza uma transferência, validando a senha.
    - `protected void imprimirInfosComuns()`: Imprime informações comuns da conta.

- `ContaCorrente.java`
  - **Descrição**: Implementa a classe `ContaCorrente` que estende `Conta`.
  - **Atributos**:
    - `private static final double TARIFA_SAQUE`
  - **Métodos**:
    - `public void imprimirExtrato()`: Imprime o extrato da conta corrente.

- `ContaPoupanca.java`
  - **Descrição**: Implementa a classe `ContaPoupanca` que estende `Conta`.
  - **Atributos**:
    - `private static final double TAXA_JUROS`
    - `private static final double LIMITE_SAQUE`
  - **Métodos**:
    - `public void imprimirExtrato()`: Imprime o extrato da conta poupança.
    - `public void calcularJuros()`: Calcula e adiciona juros ao saldo.
    - `public void sacarComLimite(double valor)`: Realiza um saque respeitando o limite.

- `IConta.java`
  - **Descrição**: Interface que define os métodos que uma conta deve implementar.
  - **Métodos**:
    - `void sacar(double valor, String senha)`
    - `void depositar(double valor)`
    - `void transferir(double valor, IConta contaDestino, String senha)`
    - `void imprimirExtrato()`

- `Main.java`
  - **Descrição**: Classe principal que contém o método `main` e a lógica de interação com o usuário.
  - **Métodos**:
    - `public static void main(String[] args)`: Método principal que executa o programa.
    - Métodos auxiliares para gerenciar as interações no modo banco e no modo cliente.

## Estrutura de Pastas

- `src/`
  - Contém todos os arquivos `.java` do projeto.

- `bin/`
  - Diretório para os arquivos `.class` compilados (gerado após a compilação).

## Como Compilar e Executar

1. **Compilar o Projeto**:
    ```sh
    javac -d bin src/*.java
    ```

2. **Executar o Projeto**:
    ```sh
    java -cp bin Main
    ```

## Contribuição

Para contribuir com este projeto, veja o README principal para detalhes sobre como fazer um fork, criar uma branch, commit suas mudanças e abrir um pull request.