abstract class SummaryFactory
{
	// Document is a made up data structure that holds "Text"
	public Document createSummary();
	{
		Document summary = new Document();
		summary.add(this.extractHypothesis());
		summary.add(this.extractConclusions());
		summary.add(this.extractExperiments());
		return summary;
	}

	abstract Text extractHypothesis();
	abstract Text extractExperiments();
	abstract Text extractConclusions();
}

class PDFSummaryFactory extends SummaryFactory
{
	// another made up data structure representing a PDF file
	private PDF file;

	public PDFSummaryFactory(PDF input)
	{
		file = input;
	}
	
	Text extractHypothesis()
	{
		// do stuff to get this section out of the PDF file
	}

	Text extractExperiments()
	{
		// do stuff to get this section out of the PDF file
	}

	Text extractConclusions()
	{
		// do stuff to get this section out of the PDF file
	}
}

public static void main(String args[])
{
	PDF someFile = args[0];
	SummaryFactory factory = new PDFSummaryFactory(someFile);
	Document summary = factory.createSummary();
}