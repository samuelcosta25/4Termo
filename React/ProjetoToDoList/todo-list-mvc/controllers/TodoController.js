import Todo from '@/models/Todo';
import connectMongo from '@/utils/mongodb';

// Metodo para pegar todas as tarefas
export const getTodos = async () => {
  await connectMongo();
  return await Todo.find({});
};

// Metodo para criar as tarefas
export const createTodo = async (data) => {
  await connectMongo();
  return await Todo.create(data);
};

// Metodo para fazer os updates
export const updateTodo = async (id, data) => {
  await connectMongo();
  return await Todo.findByIdAndUpdate(id, data, {
    new: true,
    runValidators: true,
  });
};

// Metodo para fazer os deletes
export const deleteTodo = async (id) => {
  await connectMongo();
  return await Todo.deleteOne({ _id: id });
};
