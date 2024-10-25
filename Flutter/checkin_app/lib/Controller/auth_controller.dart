import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';

class AuthController {
  final FirebaseAuth _auth = FirebaseAuth.instance;

  // Função de login
  Future<void> login({
    required String email,
    required String password,
    required BuildContext context,
  }) async {
    try {
      UserCredential userCredential = await _auth.signInWithEmailAndPassword(
        email: email,
        password: password,
      );
      Navigator.pushNamed(context, '/checkin'); // Redireciona para a tela de Check-in
    } catch (e) {
      _showError(context, 'Erro ao fazer login: $e');
    }
  }

  // Função de cadastro
  Future<void> register({
    required String email,
    required String password,
    required BuildContext context,
  }) async {
    try {
      UserCredential userCredential = await _auth.createUserWithEmailAndPassword(
        email: email,
        password: password,
      );
      Navigator.pushNamed(context, '/checkin'); // Redireciona para a tela de Check-in
    } catch (e) {
      _showError(context, 'Erro ao cadastrar: $e');
    }
  }

  // Função para mostrar mensagens de erro
  void _showError(BuildContext context, String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text(message)),
    );
  }

  // Função para verificar se o usuário está logado
  User? getCurrentUser() {
    return _auth.currentUser;
  }

  // Função de logout
  Future<void> logout(BuildContext context) async {
    await _auth.signOut();
    Navigator.pushNamedAndRemoveUntil(context, '/', (route) => false);
  }
}
