import mongoose from "mongoose";

const DATABASE_URL = process.env.DATABASE_URL;

//verificação
if(!dataBaseUrl){
    throw new Error ("Env não preenchido");
}


const connectMongo = async () => {
    if (mongoose.connection.readyState>0){
        return; // Já está conectado
    } else{
        return await mongoose.connect(dataBaseUrl).then("MongoDB Conectado").catch(err=>console.error(err)); // vou realizar a conexão
    }
}

export default connectMongo;