<?php

namespace App\Http\Controllers;

use App\Models\Inscricao;
use App\Models\Vaga;
use Illuminate\Http\Request;
use Illuminate\Routing\Controller;
use Illuminate\Support\Facades\Auth;

class InscricaoController extends Controller
{
    public function add(Request $request, Vaga $vaga){
        $inscricao=Inscricao::Create(['usuario_id' => Auth::id(), 'vaga_id' => $vaga->id]);
        

        return redirect()->route('vaga.show', $inscricao->id)->with('success', 'Incrição adicionada a vaga.');
    }
}
