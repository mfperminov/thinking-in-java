package annotations.Ex1;

// (2) implement more sql types in the database example

import examples.annotations.database.Constraints;
import examples.annotations.database.DBTable;
import examples.annotations.database.SQLInteger;
import examples.annotations.database.SQLString;

@DBTable
public class Ex1 {

  @SQLString(value = 40, name = "exampleS")
  private String exampleString = "exampleString";

  @SQLInteger(name = "exampleInt")
  private int exampleInt = 47;

  @SQLBoolean
  private boolean exampleBoolean = false;

  @SQLReal(constraints = @Constraints(allowNull = false))
  private float exampleReal = 0.01f;

  public static void main(String[] args) {
    System.out.println(Ex1.class.getName());
  }
}
