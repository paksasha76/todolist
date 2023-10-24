import './App.css'

import {TodoList} from "./TodoList/TodoList"

import {AddButton} from "./AddButton/AddButton"


function App() {
  return (
    <div className="App">
      <p class="todolist_title">TodoList</p>
     <TodoList />
     <AddButton />
    </div>
  );
}

export default App;
