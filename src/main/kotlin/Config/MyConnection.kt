package Config


import java.sql.*



class MyConnection {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val con = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/Notes_database", "root", "123456")
                val stmt = con.createStatement()
                val rs = stmt.executeQuery("select * from User")
                while (rs.next())
                    println(rs.getInt(1).toString() + "  " + rs.getString(2) + "  " + rs.getString(3))
                con.close()
            } catch (e: Exception) {
                println(e)
            }

        }
    }

}