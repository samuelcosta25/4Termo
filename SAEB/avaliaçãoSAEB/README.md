## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


adicionar: metodo clicar botao, enter + JoptionPane confirmação
excluir: metodo clicar botao, enter, drag and drop (botao excluir) + JoptionPane confirmação


SCRIPTS BANCO DE DADOS:

Tabela Tarefa:
CREATE TABLE Tarefa (
    id_tarefa SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    status VARCHAR(50),
    data_previsao DATE,
    id_funcionario INT,
    CONSTRAINT fk_funcionario
        FOREIGN KEY (id_funcionario) 
        REFERENCES Funcionario(id_funcionario)
        ON DELETE SET NULL
);

Tabela Funcionario:
CREATE TABLE Funcionario (
    id_funcionario SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    setor VARCHAR(100),
    registro VARCHAR(20),
    cargo VARCHAR(100),
    contato VARCHAR(50)
);


