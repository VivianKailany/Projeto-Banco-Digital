# Projeto Banco Digital

## Descrição

Este projeto é uma implementação de um banco digital em Java. Ele permite criar contas correntes e poupança, realizar operações de depósito, saque, transferência entre contas e imprimir extratos. O projeto possui dois modos de usuário: modo banco, para administração das contas, e modo cliente, para operações nas contas, não esta finalizado ainda estou fazendo melhorias.

## Funcionalidades

### Modo Banco

- **Criar nova conta**: Permite a criação de contas correntes e poupança para novos clientes.
- **Listar contas**: Exibe a lista de todas as contas criadas.
Ainda vou adicionar os outros metodos no arquivo principal

### Modo Cliente

- **Depositar**: Permite ao cliente depositar dinheiro na conta.
- **Sacar**: Permite ao cliente sacar dinheiro da conta.
- **Transferir**: Permite ao cliente transferir dinheiro para outra conta.
- **Imprimir Extrato**: Exibe o extrato da conta do cliente.

## Como Executar

### Pré-requisitos

- Java Development Kit (JDK) 17 ou superior.
- IDE de sua preferência (Eclipse, IntelliJ, VSCode, etc.) ou um editor de texto com suporte a Java.

### Passos para Executar

1. **Clone o repositório**:
    ```sh
    git clone https://github.com/seu-usuario/seu-repositorio.git
    cd seu-repositorio
    ```

2. **Compile o projeto**:
    ```sh
    javac -d bin src/*.java
    ```

3. **Execute o projeto**:
    ```sh
    java -cp bin Main
    ```

## Uso

### Modo Banco

1. **Criar nova conta**:
    - Digite o nome, CPF, endereço, e-mail e senha do cliente.
    - Escolha o tipo de conta: corrente ou poupança.

2. **Listar contas**:
    - Exibe a lista de todas as contas criadas.

### Modo Cliente

1. **Depositar**:
    - Digite o número da conta e o valor do depósito.

2. **Sacar**:
    - Digite o número da conta, o valor do saque e a senha.

3. **Transferir**:
    - Digite o número da conta de origem, o número da conta de destino, o valor da transferência e a senha.

4. **Imprimir Extrato**:
    - Digite o número da conta para visualizar o extrato.

## Contribuição

Para contribuir com este projeto:

1. Faça um fork do repositório.
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
3. Commit suas mudanças (`git commit -am 'Adicionei uma nova funcionalidade'`).
4. Push para a branch (`git push origin feature/nova-funcionalidade`).
5. Crie um novo Pull Request.