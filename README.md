# Solid
Boas práticas aplicando os 5 pricipios propostos por uncle bob.

# Princípios SOLID em Java

## 1. Introdução ao SOLID

### 1.1. O que é SOLID?

**Definição:** SOLID é um acrônimo que representa os cinco princípios essenciais de design de software em Programação Orientada a Objetos (POO).

**Origem:** Introduzido por Robert C. Martin (Uncle Bob) e popularizado por Michael Feathers.

**Objetivo:** Promover um código com as seguintes características:

- **Robustez:** Menos propenso a falhas após alterações.
- **Escalabilidade:** Fácil de evoluir e adicionar novas funcionalidades.
- **Manutenção:** Simples de entender, corrigir e adaptar.
- **Flexibilidade:** Tolerante a mudanças nos requisitos.

**Linguagem:** Embora os exemplos sejam em Java, os princípios são agnósticos de linguagem (aplicáveis em C#, Python, etc.).

### 1.2. Os Cinco Princípios

| Letra | Princípio (Inglês)           | Princípio (Português)           | Objetivo Principal                                           |
|-------|------------------------------|---------------------------------|-------------------------------------------------------------|
| **S** | Single Responsibility Principle | Princípio da Responsabilidade Única | Uma classe deve ter apenas uma razão para mudar.             |
| **O** | Open/Closed Principle         | Princípio Aberto/Fechado        | Entidades de software (classes, módulos) devem ser abertas para extensão, mas fechadas para modificação. |
| **L** | Liskov Substitution Principle  | Princípio da Substituição de Liskov | Objetos em um programa devem ser substituíveis por instâncias de seus subtipos sem alterar a correção desse programa. |
| **I** | Interface Segregation Principle | Princípio da Segregação de Interfaces | Clientes não devem ser forçados a depender de interfaces que não utilizam. |
| **D** | Dependency Inversion Principle | Princípio da Inversão de Dependência | Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. |

## 2. O Princípio da Responsabilidade Única (SRP)

### 2.1. Conceito Central

**Regra:** Uma classe deve ter apenas uma responsabilidade.

**Entendimento Prático:** Uma classe deve ter apenas uma razão para mudar. Se o requisito para salvar no banco de dados mudar, apenas a classe de persistência deve ser alterada, e não a classe que lida com a lógica de negócios.

### 2.2. O que Viola o SRP (Exemplo em Java)

Uma classe `Funcionario` que contém métodos para:

- `calculaSalario()` (Lógica de Negócios)
- `salvarNoBanco()` (Persistência de Dados)
- `gerarRelatorio()` (Formatação/Relatório)

### 2.3. Aplicação do SRP (Melhoria em Java)

**Separação de Preocupações:** Dividir as responsabilidades em classes separadas:

- `Funcionario` (Apenas os dados e a lógica essencial do funcionário).
- `CalculadoraDeSalario` (Responsável apenas pela regra de cálculo).
- `FuncionarioRepository` (Responsável apenas pela persistência de dados).

## 3. O Princípio Aberto/Fechado (OCP)

### 3.1. Conceito Central

**Regra:** Aberto para extensão, fechado para modificação.

**Entendimento Prático:** Deve ser possível adicionar novo comportamento a um módulo sem precisar alterar o código-fonte existente.

### 3.2. O que Viola o OCP (Exemplo em Java)

Uma classe `CalculadoraDeImposto` com um método que usa uma longa estrutura `if/else` ou `switch` para calcular o imposto com base no `tipoDeProduto`.

```java
// Violação
public class CalculadoraDeImposto {

    public double calcular(Produto produto) {

        if (produto.getTipo().equals("LIVRO")) { /*...*/ }

        else if (produto.getTipo().equals("ALIMENTO")) { /*...*/ }

        // Se um novo tipo ("SERVICO") surgir, esta classe PRECISA ser modificada.

    }
}
