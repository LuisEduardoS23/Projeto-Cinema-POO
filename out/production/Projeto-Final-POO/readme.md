# 🎬 Sistema de Gerenciamento de Cinema

## 📌 Descrição do Projeto

Este projeto foi desenvolvido como atividade final da disciplina **Programação Orientada a Objetos (POO)**, ministrada pelo professor **Dr. Wilker Luz** no Instituto Federal de Educação, Ciência e Tecnologia do Maranhão (IFMA) – Campus Caxias.

O sistema simula o gerenciamento de um cinema com múltiplas salas, permitindo o controle de sessões, assentos e venda de ingressos com aplicação de descontos conforme a categoria do cliente. O projeto foi desenvolvido em **Java**, utilizando os principais conceitos de **POO**: encapsulamento, herança, polimorfismo e composição.

**🔍 Para conferir o PDF da avaliação clique:** [📄 Veja o PDF aqui](src/Desafio/avaliacao.pdf) 

---

## 👥 Autores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/joaobatistamedeiroscf">
        <img src="https://github.com/joaobatistamedeiroscf.png" width="100px;" alt="João Batista Medeiros"/><br />
        <sub><b>João Batista Medeiros</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/LuisEduardoS23">
        <img src="https://github.com/LuisEduardoS23.png" width="100px;" alt="Luis Eduardo Silva Soares"/><br />
        <sub><b>Luis Eduardo Silva Soares</b></sub>
      </a>
    </td>
  </tr>
</table>

---

## 🎯 Funcionalidades Principais

- 📽️ Cadastro de filmes e atribuição a salas  
- 🪑 Visualização da ocupação dos assentos por sala  
- 🎟️ Compra de ingressos com seleção de sala, fileira e assento  
- 💸 Aplicação automática de descontos por categoria:
  - Normal: 0%
  - Estudante: 50%
  - Idoso (60+): 100%
  - Professor: 30%

---

## 🧱 Estrutura de Classes

- `Pessoa` (abstrata): nome, idade, senha  
- `Filme`: título, duração, gênero  
- `Sala`: número, matriz de assentos, filme em exibição  
- `Assento`: fileira (A-T), número (1-10), status  
- `Ingresso`: pessoa, sala, assento, preço final  
- `Cinema`: lista de salas e lógica de venda de ingressos  

---

## 📂 Estrutura de Pastas

A seguir, a organização de diretórios e arquivos Java no projeto:

```
PROJETO-FINAL-POO/
├── src/
│   ├── controller/
│   │   └── Sistema.java
│   ├── model/
│   │   ├── Administrador.java
│   │   ├── Filme.java
│   │   ├── Pessoa.java
│   │   ├── PessoaEstudante.java
│   │   ├── PessoaIdoso.java
│   │   ├── PessoaNormal.java
│   │   ├── PessoaProfessor.java
│   │   └── Sessao.java
│   ├── util/
│   │   └── Contador.java
│   └── Main.java
└── readme.md

```

---

## ⚙️ Tecnologias Utilizadas

- Java 17+  
- IDE: Visual Studio Code e IntelliJ  s
- Terminal de Console (para interação textual)  

---

## 💡 Conceitos Aplicados

- ✅ Encapsulamento  
- ✅ Herança  
- ✅ Polimorfismo  
- ✅ Composição  
- ✅ Uso de Arrays e controle manual de objetos  

---

## 📸 Execução

A interface do sistema é feita por linha de comando (console).O usuário escolhe entre as opções do menu para navegar pelas funcionalidades como cliente ou administrador.

---

© 2025 – Projeto desenvolvido para fins acadêmicos no IFMA – Campus Caxias.
