<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;


class Membros extends Authenticatable
{
    use Notifiable, HasFactory;
    protected $fillable = [
        'id_membro', 'nome', 'email', 'telefone', 'cpf_membro', 'password'
    ];
    protected $hidden = [
        'password', 'remember_token',
    ];
    public function inscricao(){
        return $this->hasMany(Inscricao::class);
    }
}
