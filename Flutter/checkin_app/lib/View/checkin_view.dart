import 'package:flutter/material.dart';
import '../Controller/local_controller.dart';

class CheckinView extends StatelessWidget {
  final LocalController localController = LocalController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Check-in')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () async {
                try {
                  final position = await localController.getCurrentLocation();
                  print("Latitude: ${position.latitude}, Longitude: ${position.longitude}");
                  // Aqui você pode enviar as coordenadas para o Firebase
                } catch (e) {
                  localController.showError(context, 'Erro ao obter localização: $e');
                }
              },
              child: Text('Fazer Check-in'),
            ),
            SizedBox(height: 20),
            Text('Sua localização será verificada.'),
          ],
        ),
      ),
    );
  }
}
