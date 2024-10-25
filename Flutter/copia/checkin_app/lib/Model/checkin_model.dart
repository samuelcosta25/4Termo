class CheckinModel {
  String? idCheckin; // Identificador único do check-in
  String local;
  String evento;
  DateTime data;
  String hora;

  CheckinModel({
    this.idCheckin, // Pode ser nulo na criação e ser definido depois
    required this.local,
    required this.evento,
    required this.data,
    required this.hora,
  });

  // Converte o objeto CheckinModel para um Map (útil para salvar no Firebase)
  Map<String, dynamic> toMap() {
    return {
      'idCheckin': idCheckin,
      'local': local,
      'evento': evento,
      'data': data.toIso8601String(),
      'hora': hora,
    };
  }

  // Cria um objeto CheckinModel a partir de um Map (útil para ler do Firebase)
  factory CheckinModel.fromMap(Map<String, dynamic> map) {
    return CheckinModel(
      idCheckin: map['idCheckin'],
      local: map['local'] ?? '',
      evento: map['evento'] ?? '',
      data: DateTime.parse(map['data'] ?? DateTime.now().toIso8601String()),
      hora: map['hora'] ?? '',
    );
  }

  // Método auxiliar para definir o idCheckin se ele não estiver presente
  void setIdCheckin(String novoId) {
    idCheckin ??= novoId;
  }
}
