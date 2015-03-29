Hibernate-projection-nplusone
=============================

This app generates that Hibernate sometimes generates
inefficient n+1 queries.

Run it with `mvn clean compile exec:java -Dexec.mainClass="com.devcrumb.App"`.

The Hibernate output log shows multiple queries for `PersonType`:

```
Hibernate: select distinct this_.personType_id as y0_ from Person this_ where this_.name like ?
Hibernate: select persontype0_.id as id1_0_, persontype0_.name as name1_0_ from PersonType persontype0_ where persontype0_.id=?
Hibernate: select persontype0_.id as id1_0_, persontype0_.name as name1_0_ from PersonType persontype0_ where persontype0_.id=?
```

I expect there to be at most 2 queries: one to get the `PersonType` IDs and one to get the `PersonType`s. Ideally, only one query would be executed to fetch all the `PersonType`s.