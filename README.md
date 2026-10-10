# Array de primitivos vs. array de objetos em Java

## Visão geral

Em Java, todo array é um **objeto** e fica armazenado no *heap*. A diferença está no que cada posição do array guarda:

| Característica | `int[]`, `double[]` | `Aluno[]`, `Produto[]` |
|---|---|---|
| O que cada posição guarda | O **valor** em si | Uma **referência** (endereço) para um objeto |
| Valor inicial após `new` | `0`, `0.0`, `false`, `'\u0000'` | `null` |
| Os objetos já existem após `new`? | Não se aplica | **Não**, só o array foi criado |
| Pode dar `NullPointerException`? | Não | **Sim** |

---

## a) Como a memória é alocada em cada caso?

### Array de primitivos

Com `new int[3]`, o Java aloca no heap **um único bloco contínuo** com espaço para os três valores. Os próprios valores ficam dentro do array.

```java
int[] numeros = new int[3];
numeros[0] = 10;
numeros[1] = 20;
```

```
Stack                 Heap
numeros ───────────►  [ 10 | 20 | 0 ]
(referência)            valores guardados direto no array
```

### Array de objetos

Com `new Aluno[3]`, o Java aloca apenas um bloco com **3 referências**, todas `null`. **Nenhum objeto `Aluno` é criado** nesse momento. Cada objeto precisa ser criado separadamente com `new Aluno(...)`, e fica em outra área do heap.

```java
Aluno[] alunos = new Aluno[3];
alunos[0] = new Aluno("Maria", "20261001");
alunos[1] = new Aluno("João", "20261002");
// alunos[2] continua null
```

```
Stack                 Heap
alunos ─────────────► [ ref0 | ref1 | null ]
(referência)             │      │
                         │      └──► Aluno("João", ...)
                         └─────────► Aluno("Maria", ...)
```

### Resumo da diferença

- **Primitivos:** um nível só. O array contém os dados.
- **Objetos:** dois níveis. O array contém referências, e os dados estão nos objetos apontados.
- Em arrays de objetos, dois índices podem apontar para o **mesmo objeto**, o que não acontece com primitivos (cada posição tem seu próprio valor).

```java
alunos[2] = alunos[0]; // as duas posições apontam para o mesmo Aluno
alunos[2].cadastrarNota(9.0); // altera também o alunos[0]
```

---

## b) Cuidados ao acessar elementos de um array de objetos

### 1. Posições `null` (`NullPointerException`)

Depois de `new Aluno[3]`, todas as posições são `null`. Chamar um método em uma posição não preenchida lança exceção.

```java
Aluno[] alunos = new Aluno[3];
alunos[0].getNome(); // NullPointerException!
```

**Como evitar:**

```java
if (alunos[0] != null) {
    System.out.println(alunos[0].getNome());
}
```

### 2. Percorrer só as posições preenchidas

Se o array não está cheio, o laço deve parar na quantidade real de elementos, ou testar `null`. Foi isso que o contador `quantidadeAlunos` fez na classe `Turma`.

```java
for (int i = 0; i < quantidadeAlunos; i++) {
    System.out.println(alunos[i].getNome());
}
```

### 3. Índices fora do limite (`ArrayIndexOutOfBoundsException`)

Vale para qualquer array: o índice válido vai de `0` até `length - 1`.

```java
alunos[3] = new Aluno("Ana", "20261003"); // erro em array de tamanho 3
```

### 4. Criar cada objeto antes de usar

Declarar o array **não** cria os objetos. É preciso instanciar cada um.

```java
for (int i = 0; i < alunos.length; i++) {
    alunos[i] = new Aluno("Aluno " + i, "2026" + i);
}
```

### 5. Atenção ao compartilhamento de referências

Copiar um array de objetos com `clone()` ou `Arrays.copyOf()` faz uma **cópia rasa**: o novo array tem as mesmas referências, e os objetos continuam sendo os mesmos.

```java
Aluno[] copia = alunos.clone();
copia[0].cadastrarNota(5.0); // altera também o alunos[0]
```

Para uma cópia independente, é preciso criar novos objetos para cada posição.

### 6. Comparar objetos com `equals`, não com `==`

O `==` compara **referências**, não o conteúdo dos objetos.

```java
Aluno a = new Aluno("Maria", "1");
Aluno b = new Aluno("Maria", "1");
System.out.println(a == b); // false: são objetos diferentes
```

Para comparar por conteúdo, a classe deve sobrescrever `equals()`.

---

## Resumo dos cuidados

1. Checar `null` antes de acessar uma posição.
2. Percorrer apenas as posições preenchidas.
3. Respeitar os limites do array (`0` a `length - 1`).
4. Instanciar cada objeto com `new` antes de usá-lo.
5. Lembrar que cópias de arrays de objetos são rasas.
6. Usar `equals()` para comparar conteúdo.
