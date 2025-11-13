# Solid
Boas práticas aplicando os 5 pricipios propostos por uncle bob.

## 🧱 Princípios SOLID em Java: Uma Visão Geral

-----

### 1\. Introdução ao SOLID 💡

**1.1. O que é SOLID?**

  * **Definição:** SOLID é um **acrônimo** que representa os **cinco princípios** essenciais de design de software em Programação Orientada a Objetos (**POO**).
  * **Origem:** Introduzido por **Robert C. Martin** (Uncle Bob) e popularizado por Michael Feathers.
  * **Objetivo Principal:** Promover um código de **alta qualidade**, com as seguintes características:
      * **Robustez:** Menos propenso a falhas após alterações.
      * **Escalabilidade:** Fácil de evoluir e adicionar novas funcionalidades.
      * **Manutenção:** Simples de entender, corrigir e adaptar.
      * **Flexibilidade:** Tolerante a mudanças nos requisitos.
  * **Linguagem:** Embora os exemplos sejam em Java, os princípios são **agnósticos de linguagem** (aplicáveis em C\#, Python, etc.).

**1.2. Os Cinco Princípios**

| Letra | Princípio (Inglês) | Princípio (Português) | Objetivo Principal |
| :---: | :---: | :---: | :---: |
| **S** | Single Responsibility Principle | **Responsabilidade Única** | Uma classe deve ter apenas uma **razão para mudar**. |
| **O** | Open/Closed Principle | **Aberto/Fechado** | Aberto para **extensão**, mas fechado para **modificação**. |
| **L** | Liskov Substitution Principle | **Substituição de Liskov** | Objetos de subtipos devem ser **substituíveis** por objetos de seus tipos base sem quebrar o programa. |
| **I** | Interface Segregation Principle | **Segregação de Interfaces** | Clientes não devem depender de interfaces que **não utilizam** (preferir interfaces pequenas e específicas). |
| **D** | Dependency Inversion Principle | **Inversão de Dependência** | Módulos devem depender de **abstrações** (Interfaces), e não de detalhes (Classes concretas). |

-----

### 2\. O Princípio da Responsabilidade Única (**SRP**)

**2.1. Conceito Central**

  * **Regra:** Uma classe deve ter apenas **uma responsabilidade** (ou, mais precisamente, **uma razão para mudar**).
  * **Entendimento Prático:** Se o requisito para salvar no banco de dados mudar, apenas a classe de persistência deve ser alterada, e não a classe que lida com a lógica de negócios.

**2.2. O que Viola o SRP (Exemplo em Java)**

Uma classe `Funcionario` que contém métodos para:

  * `calculaSalario()` (**Lógica de Negócios**)
  * `salvarNoBanco()` (**Persistência de Dados**)
  * `gerarRelatorio()` (**Formatação/Relatório**)

**2.3. Aplicação do SRP (Melhoria em Java)**

  * **Separação de Preocupações:** Dividir as responsabilidades em classes separadas:
      * `Funcionario` (Apenas os dados e a lógica essencial do funcionário).
      * `CalculadoraDeSalario` (Responsável apenas pela regra de cálculo).
      * `FuncionarioRepository` (Responsável apenas pela persistência de dados).

-----

### 3\. O Princípio Aberto/Fechado (**OCP**)

**3.1. Conceito Central**

  * **Regra:** **Aberto para extensão, fechado para modificação**.
  * **Entendimento Prático:** Deve ser possível adicionar **novo comportamento** a um módulo **sem precisar alterar o código-fonte existente**.

**3.2. O que Viola o OCP (Exemplo em Java)**

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
```

**3.3. Aplicação do OCP (Melhoria em Java)**

  * Uso de **Abstração** (Interfaces ou Classes Abstratas) e **Polimorfismo**.
  * Criação de uma Interface Abstrata: `Interface Imposto`.
  * Implementação de classes concretas: `ImpostoLivro`, `ImpostoAlimento`, `ImpostoServico`.
  * A classe `CalculadoraDeImposto` passa a depender da interface:

<!-- end list -->

```java
// Aplicação do OCP
public class CalculadoraDeImposto {
    public double calcular(Imposto imposto) {
        return imposto.calcularValor(); // Fechada para modificação
    }
}
// Novo comportamento é adicionado via EXTENSÃO (nova classe ImpostoServico)
```

-----

### 4\. O Princípio da Substituição de Liskov (**LSP**)

**4.1. Conceito Central**

  * **Regra:** Se S é um subtipo de T, então objetos do tipo T podem ser substituídos por objetos do tipo S sem quebrar o programa.
  * **Entendimento Prático:** O comportamento de uma subclasse não deve ir **contra a expectativa** definida pela sua superclasse.

**4.2. O que Viola o LSP (Exemplo em Java)**

  * **Hierarquia de Herança Incorreta (O "problema do quadrado e retângulo"):**
      * `Classe Retangulo` com métodos `setLargura(double l)` e `setAltura(double a)`.
      * `Classe Quadrado` (que estende `Retangulo`). Ao chamar `setLargura(10)` em um `Quadrado`, ele muda o valor da altura para 10 também para manter a propriedade de quadrado.
      * Isso viola a expectativa do código cliente que usa um `Retangulo` (que espera que largura e altura possam ser definidas independentemente).

**4.3. Aplicação do LSP (Melhoria em Java)**

  * Garantir que os métodos das subclasses **não alterem o contrato** estabelecido pela superclasse (ex: não lançar exceções inesperadas, não ter pré-condições mais fortes).
  * **Solução para o Exemplo:** `Quadrado` e `Retangulo` não devem ter uma relação de herança direta. Ambos deveriam implementar uma interface comum, como `FormaGeometrica`.

-----

### 5\. O Princípio da Segregação de Interfaces (**ISP**)

**5.1. Conceito Central**

  * **Regra:** Clientes **não devem ser forçados a depender de métodos** (em uma interface) que eles **não usam**.
  * **Entendimento Prático:** É melhor ter **muitas interfaces pequenas e específicas** do que uma única interface "gorda" e monolítica.

**5.2. O que Viola o ISP (Exemplo em Java)**

  * **Interface "Gorda":** Interface `FuncionarioComTodasAsTarefas` com métodos como `trabalhar()`, `comer()`, `gerenciarProjetos()`, `pilotarAviao()`.
  * Uma classe `Estagiario` que implementa essa interface é forçada a implementar (ou deixar vazios/lançar erro em) métodos como `gerenciarProjetos()` e `pilotarAviao()`, que não fazem parte de sua responsabilidade.

**5.3. Aplicação do ISP (Melhoria em Java)**

  * **Segregar (Dividir) as Interfaces:**
      * `Interface Trabalhador` (`trabalhar()`, `comer()`).
      * `Interface Gerente` (estende `Trabalhador`, e adiciona `gerenciarProjetos()`).
  * A classe `Estagiario` implementa apenas a `Interface Trabalhador`.

-----

### 6\. O Princípio da Inversão de Dependência (**DIP**)

**6.1. Conceito Central**

  * **Regra 1:** Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de **abstrações**.
  * **Regra 2:** Abstrações não devem depender de detalhes. Detalhes devem depender de **abstrações**.
  * **Entendimento Prático:** Em vez de uma classe de alto nível (Lógica de Negócios) se referir diretamente a uma classe de baixo nível (Implementação de Banco de Dados), ambas devem depender de uma **Interface/Abstração**.

**6.2. O que Viola o DIP (Exemplo em Java)**

A classe `ServicoDePedido` (alto nível) cria diretamente ou tem como atributo a classe concreta `MySqlRepository` (baixo nível).

```java
// Violação - Alta dependência de uma implementação concreta (acoplamento)
public class ServicoDePedido {
    private MySqlRepository repository = new MySqlRepository();

    public void salvarPedido() {
        repository.salvar(); // Acoplamento com MySqlRepository
    }
}
```

**6.3. Aplicação do DIP (Melhoria em Java)**

  * Uso de **Interfaces** (Abstrações) para conectar os módulos.
  * Criação da Interface: `Interface PedidoRepository`.
  * A classe de alto nível (`ServicoDePedido`) depende apenas da **Interface**, e a implementação concreta é **injetada** (**Injeção de Dependência**).

<!-- end list -->

```java
// Aplicação do DIP - Depende da abstração (Interface)
public class ServicoDePedido {
    // Depende de uma abstração (Interface), não de um detalhe (Classe concreta)
    private final PedidoRepository repository; 

    // Inversão de Controle: a dependência é INJETADA
    public ServicoDePedido(PedidoRepository repository) { 
        this.repository = repository;
    }

    public void salvarPedido() {
        repository.salvar(); // Não sabe se é MySql, Oracle, etc.
    }
}
```

-----

### 7\. Conclusão ✅

A aplicação dos princípios **SOLID** em Java, utilizando recursos como **Interfaces**, Classes Abstratas e Herança, resulta em um código mais **modular**, **testável** e **fácil de evoluir**. Um código que segue o SOLID é a base para o desenvolvimento de software robusto e de alta qualidade, fundamental para a criação de sistemas com **Arquitetura Limpa** (Clean Architecture).

-----
    }
}
