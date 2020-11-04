import model.Sentence;
import model.WrapperClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlConverter implements Converter {
    public void generate(List<Sentence> sentenceList) throws JAXBException {


        try {

            File file = new File("C:\\Users\\zajaw\\IdeaProjects\\InvictaExercise\\src\\main\\resources\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Sentence.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            WrapperClass wrapperClass = new WrapperClass(sentenceList);
            jaxbMarshaller.marshal(wrapperClass, file);
            jaxbMarshaller.marshal(wrapperClass, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}

