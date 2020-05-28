package id.ac.unhas.finaltodolist.database

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unhas.finaltodolist.ToDo

//Database Access Object
@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    fun getTodos(): LiveData<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: ToDo)

    @Update
    suspend fun updateTodo(todo: ToDo)

    @Delete
    suspend fun deleteTodo(todo: ToDo)
}