<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('inscricoes', function (Blueprint $table) {
            $table->id();
            $table->foreignId('id_gerente')->constrained('gerentes')->
            onDelete('cascade');  // Relaciona o projeto ao gerente 
            $table->timestamps();
        });
    }
   
    public function down(): void
    {
        Schema::dropIfExists('projetos');
    }
};
