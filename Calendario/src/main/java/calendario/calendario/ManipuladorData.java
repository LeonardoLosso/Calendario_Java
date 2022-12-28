package calendario.calendario;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Leo
 */
public final class ManipuladorData {
    public GregorianCalendar gc = new GregorianCalendar();;
    public int diahoje, meshoje, anohoje, diasemana;
    public int diasmes;
    public int semanaDoMes;
    public final int dia = Calendar.DAY_OF_MONTH;
    
    public ManipuladorData(){
        this.gc.set(Calendar.DAY_OF_MONTH, 1);
        inicializaData();
    }
    public void inicializaData(){
        this.anohoje = this.gc.get(Calendar.YEAR);
        this.meshoje = this.gc.get(Calendar.MONTH);
        this.diahoje = this.gc.get(Calendar.DAY_OF_MONTH);
        this.diasemana = this.gc.get(Calendar.DAY_OF_WEEK);
        this.semanaDoMes = this.gc.get(Calendar.WEEK_OF_MONTH);
        this.diasmes = this.gc.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    public static String formatDateToLocale(Date data, String formato, Locale localeSaida) {

    SimpleDateFormat dateFormatSaida = new SimpleDateFormat(formato, localeSaida);

    String novoFormato;

    novoFormato = dateFormatSaida.format(data);
    return novoFormato;
    }
    public String getMes(){
        Date data = new Date(anohoje, meshoje, diahoje);
        String m = (formatDateToLocale(data, "MMMM", new Locale("pt", "BR")));
        return m.substring(0,1).toUpperCase().concat(m.substring(1));
    }
    public void manipulaCalendario(int n){
        gc.add((Calendar.MONTH), n);
        inicializaData();
    }
}