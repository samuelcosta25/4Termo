class UsuarioModel {
  String? idCliente; // Identificador único do cliente
  String cpf;
  String email;
  String username;
  String nome;
  String telefone;
  String senha;

  UsuarioModel({
    this.idCliente, // Pode ser nulo ao criar um novo usuário
    required this.cpf,
    required this.email,
    required this.username,
    required this.nome,
    required this.telefone,
    required this.senha,
  });

  // Converte o objeto UsuarioModel para um Map (útil para gravar no Firebase)
  Map<String, dynamic> toMap() {
    return {
      'idCliente': idCliente,
      'cpf': cpf,
      'email': email,
      'username': username,
      'nome': nome,
      'telefone': telefone,
      'senha': senha,
    };
  }

  // Cria um objeto UsuarioModel a partir de um Map (útil para ler do Firebase)
  factory UsuarioModel.fromMap(Map<String, dynamic> map) {
    return UsuarioModel(
      idCliente: map['idCliente'],
      cpf: map['cpf'] ?? '',
      email: map['email'] ?? '',
      username: map['username'] ?? '',
      nome: map['nome'] ?? '',
      telefone: map['telefone'] ?? '',
      senha: map['senha'] ?? '',
    );
  }

  // Método auxiliar para definir o idCliente se ele não estiver presente
  void setIdCliente(String novoId) {
    idCliente ??= novoId;
  }
}
