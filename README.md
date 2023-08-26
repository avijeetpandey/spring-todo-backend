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

## How to run project ?
Clone the project and install the required dependencies in the gradle file
- Spring web
- Spring dev tools 
- Spring JPA
- MySQL connector
- Lombok

After that open IDE of your choice and run `SpringTodoBackendApplication` class and the server will be
running on `PORT = 9000`

You can also configure the project setting as per local system eg MySQL etc
in the `application.properties` file