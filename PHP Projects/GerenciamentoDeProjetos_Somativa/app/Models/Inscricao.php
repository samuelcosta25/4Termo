<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class Inscricao extends Model
{
    use HasFactory;
    protected $fillable = [
        'id_membro'
    ];
    protected $hidden = [
        'password', 'remember_token',
    ];

    public function membros(){
        return $this->belongsTo(Membros::class);
    }

    public function projetos(){
        return $this->belongsTo(Projetos::class);
    }
}
