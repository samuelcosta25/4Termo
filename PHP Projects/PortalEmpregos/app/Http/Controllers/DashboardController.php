<?php

namespace App\Http\Controllers;

use App\Models\Vaga;
use Illuminate\Http\Request;
use Illuminate\Routing\Controller;
use function Laravel\Prompts\search;

class DashboardController extends Controller
{
    public function index(Request $request){
        $search= $request->input('search');
        $produtos= Vaga::when($search, function($query, $search){
            return $query->where('titulo', 'like', "%{$search}%")
                        ->orwhere('descricao','like', "%{$search}%")
                        ->orwhere('descricao','like', "%{$search}%")
                        ->orwhere('descricao','like', "%{$search}%");
        })->get();
        
        return view('usuarios.dashboard', compact('vagas'));
        }
}
