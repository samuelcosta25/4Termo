<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class Projetos extends Model
{
    use HasFactory;
    protected $fillable = [
        'data_entrega', 'id_gerente'
    ];
    protected $hidden = [
        'password', 'remember_token',
    ];

    public function gerente(){
        return $this->belongsTo(Gerente::class);
    }

    public function inscricao(){
        return $this->hasMany(Inscricao::class);
    }
}
