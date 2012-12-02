

public abstract class SummaryPublisher
{
   Public Summary summarizePaper(String type)
   {
      Summary summary;
      summary = createSummary(type);
   }
   
   abstract Summary createSummary(String type);
}

CloudSummaryPublisher extends SummaryPublisher
{
   Summary summary;
   public Summary createSummary(String type)
   {
      if(type == "PDF")
      {
         summary = new PdfSummary(); // 'has a' dependency on concrete 
      }                              // PdfSummary type, which in turn
      else if(type == "ODT")         // is dependent on abstract Summary 
      {
         summary = new OdtSummary();
      else // etc...


public abstract class Summary 
{
   Hypothesis hypothesis;   // to be defined in the class(es)
   Experiments experiments; // that extend this class
   // etc for other sections

   public void prepareSections()
   {
      // do whatever to put the sections together
   }

   // also have 'helper' methods if needed
}


public class PdfSummary extends Summary 
{
	public PdfSummary() 
	{
		hypothesis = extractHypothesis()
      { // libraries exist for extracting sections }

      experiments = extractExperiments()
      { // libraries exist for extracting sections }

      //etc for other sections
	}
}
