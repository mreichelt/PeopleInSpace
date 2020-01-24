package com.surrus.common.repository

import com.surrus.common.remote.Assignment
import com.surrus.common.remote.PeopleInSpaceApi
import com.surrus.peopleinspace.db.PeopleInSpaceDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

expect fun createDb() : PeopleInSpaceDatabase

class PeopleInSpaceRepository {
    private val peopleInSpaceApi = PeopleInSpaceApi()
    private val peopleInSpaceDatabase = createDb()
    private val peopleInSpaceQueries = peopleInSpaceDatabase.peopleInSpaceQueries



    suspend fun fetchPeople() : List<Assignment> {
        val result = peopleInSpaceApi.fetchPeople()
        val people = result.people

        people.forEach {
            peopleInSpaceQueries.insertItem(it.name, it.craft)
        }


//        val people = peopleInSpaceQueries.selectAll(mapper = { name, craft ->
//            Assignment(name = name, craft = craft)
//        }).executeAsList()

        return people
    }

    fun fetchPeople(success: (List<Assignment>) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            success(fetchPeople())
        }
    }
}
