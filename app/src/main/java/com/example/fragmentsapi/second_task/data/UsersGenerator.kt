package com.example.fragmentsapi.second_task.data

object UsersGenerator {
    private const val MAX_USERS = 4
    var users = listOf<User>()
        private set

    init {
        users = userList()
    }

    private fun userList(): List<User> {
        val contacts = mutableListOf<User>()
        for (i in 1..MAX_USERS) {
            contacts.add(User(i, "Имя$i", "Фамилия$i", "8-800-$i$i"))
        }
        return contacts
    }

    private fun getUser(userId: Int) = users.find { it.id == userId }

    fun editUserName(userId: Int, userName: String) {
        val user = getUser(userId)
        user?.let { user ->
            user.name = userName
        }
    }

    fun editUserLastName(userId: Int, lastName: String) {
        val user = getUser(userId)
        user?.let { user ->
            user.lastName = lastName
        }
    }

    fun editUserNumber(userId: Int, number: String) {
        val user = getUser(userId)
        user?.let { user ->
            user.phoneNumber = number
        }
    }
}