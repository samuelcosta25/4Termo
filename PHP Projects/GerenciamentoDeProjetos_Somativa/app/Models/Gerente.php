<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;


class Gerente extends Authenticatable
{
    use Notifiable, HasFactory;
    protected $fillable = [
        'id_gerente', 'nome', 'email', 'telefone', 'cpf_gerente', 'password'
    ];
    protected $hidden = [
        'password', 'remember_token',
    ];
    public function projetos(){
        return $this->hasMany(Projetos::class);
    }
}
