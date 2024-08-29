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
            $table->foreignId('id_membro')->constrained('membros')->
            onDelete('cascade');  // Relaciona a inscrição ao membro
            $table->timestamps();
        });
    }
    public function down(): void
    {
        Schema::dropIfExists('inscricoes');
    }
};
