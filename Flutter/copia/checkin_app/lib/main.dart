import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'View/login_view.dart';
import 'View/cadastro_view.dart';
import 'View/checkin_view.dart';
import 'Controller/local_controller.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: LoginView(),
      routes: {
        '/cadastro': (context) => CadastroView(),
        '/checkin': (context) => CheckinView(),
      },
    );
  }
}
