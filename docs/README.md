# macdonald Task Manager User Guide

## Introduction
Welcome to **MacDonald Task Manager**, a simple and efficient task management application that helps you organize your to-dos, deadlines, and events. This guide will walk you through the features and how to use them effectively.

## Features
Here is a condensed table with all the commands available:

| Command         | Description | Example Input | Expected Output |
|----------------|------------|---------------|----------------|
| `list`         | Displays all tasks in the list. | `list` | `Here are your tasks: ` A numbered list of tasks. |
| `todo`         | Adds a to-do task. | `todo Buy groceries` | `Added: [T][ ] Buy groceries` |
| `deadline`     | Adds a task with a deadline. | `deadline Submit report /by Sunday` | `Added: [D][ ] Submit report (by: Sunday)` |
| `event`        | Adds an event with a time range. | `event Team meeting /from Monday /to Tuesday` | `Added: [E][ ] Team meeting (from: Monday to: Tuesday)` |
| `mark`         | Marks a task as done. | `mark 1` | `Marked as done: [T][X] Buy groceries` |
| `unmark`       | Unmarks a task (marks it as not done). | `unmark 1` | `Marked as not done: [T][ ] Buy groceries` |
| `delete`       | Deletes a task from the list. | `delete 2` | `Deleted: [D][ ] Submit report` |
| `find`         | Searches for tasks with a keyword. | `find report` | `Here are the matching tasks: 1. [D][ ] Submit report` |
| `bye`          | Exits the application with a farewell message. | `bye` | `DE DE DE DENG DENG! Goodbye! Have a great day!` |

## Storage
- All tasks are automatically saved to `macdonald_tasks.txt` and loaded upon startup.
- As well as when adding, marking, unmarking, or deleting tasks.

## Sample Usage of each command
### 1. View Task List
**Command:** `list`

**Description:** Displays all tasks currently stored in the task list.

**Example Usage:**
```
list
```

**Expected Output:**
```
Here are your tasks:
1. [T][ ] Buy groceries
2. [D][X] Submit assignment (by: 2025-03-10)
3. [E][ ] Attend meeting (from: 10AM to: 12PM)
___________________________________________________________
```

### 2. Add a Todo Task
**Command:** `todo <task_description>`

**Description:** Adds a new to-do task.

**Example Usage:**
```
todo Buy groceries
```

**Expected Output:**
```
Added: [T][ ] Buy groceries
You now have 1 task.
___________________________________________________________
```

### 3. Add a Deadline Task
**Command:** `deadline <task_description> /by <date/time>`

**Description:** Adds a task with a deadline.

**Example Usage:**
```
deadline Submit assignment /by 2025-03-10
```

**Expected Output:**
```
Added: [D][ ] Submit assignment (by: 2025-03-10)
You now have 2 tasks.
___________________________________________________________
```

### 4. Add an Event Task
**Command:** `event <task_description> /from <start_time> /to <end_time>`

**Description:** Adds an event task with a start and end time.

**Example Usage:**
```
event Attend meeting /from 10AM /to 12PM
```

**Expected Output:**
```
Added: [E][ ] Attend meeting (from: 10AM to: 12PM)
You now have 3 tasks.
___________________________________________________________
```

### 5. Mark a Task as Done
**Command:** `mark <task_number>`

**Description:** Marks the specified task as done.

**Example Usage:**
```
mark 2
```

**Expected Output:**
```
Marked as done: [D][X] Submit assignment (by: 2025-03-10)
___________________________________________________________
```

### 6. Unmark a Task
**Command:** `unmark <task_number>`

**Description:** Marks the specified task as not done.

**Example Usage:**
```
unmark 2
```

**Expected Output:**
```
Marked as not done: [D][ ] Submit assignment (by: 2025-03-10)
___________________________________________________________
```

### 7. Delete a Task
**Command:** `delete <task_number>`

**Description:** Removes the specified task from the list.

**Example Usage:**
```
delete 1
```

**Expected Output:**
```
Deleted: [T][ ] Buy groceries
You now have 2 tasks remaining.
___________________________________________________________
```

### 8. Find a Task
**Command:** `find <keyword>`

**Description:** Searches for tasks containing the specified keyword.

**Example Usage:**
```
find assignment
```

**Expected Output:**
```
Here are the matching orders in your list:
1. [D][ ] Submit assignment (by: 2025-03-10)
___________________________________________________________
```

### 9. Exit the Program
**Command:** `bye`

**Description:** Exits the application with a farewell message.

**Example Usage:**
```
bye
```

**Expected Output:**
```
DE DE DE DENG DENG! Goodbye! Have a great day!
___________________________________________________________
```

## Error Handling
- If an invalid command is entered, an error message will be displayed.
- Example:

**Input:**
```
delete abc
```

**Output:**
```
ERROR: Invalid number format! Enter a valid task number.
___________________________________________________________
```

## Conclusion
Thank you for using **MacDonald Task Manager**! Manage your tasks efficiently and stay organized. 🚀
