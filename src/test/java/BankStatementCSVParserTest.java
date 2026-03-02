import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import com.extratobancario.BankStatementCSVParser;
import com.extratobancario.BankStatementParser;
import com.extratobancario.BankTransaction;

public class BankStatementCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();
    
    @Test
    public void shouldParserOneCorrectLine() throws Exception{
        final String line = "30-01-2017,-50,Tesco";
        
        final BankTransaction result = statementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
