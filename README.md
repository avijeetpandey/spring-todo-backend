## Todo application backend [WIP]
A simple Todo Application backend 
made using spring and Java , still 
a work in progress


## Implemented Features
- Ability to create a todo
- Mark a todo complete
- Delete a todo
- Update a todo
- Ability to get list of all todo's
- Global ApiResponse handler to handle both success and failure cases of the API
- Custom exceptions ex ResourceNotFoundException

### ToDo structure
Todo {
   title: String
   isCompleted: Boolean
   createdAt: Date
}