/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;

/**
 *
 * @author Martin Wulff
 */
public class Brain {

    private MultiLayerNetwork model;

    public void brain() {
        try {
            String simpleMlp = new ClassPathResource(
                    "Model.h5").getFile().getPath();
            model = KerasModelImport.
                    importKerasSequentialModelAndWeights(simpleMlp);
        } catch (Exception e) {
            System.out.println("Loading went wrong");
        }

    }

    public int usebrain(int[] something) {
        int inputs = 100;
        INDArray features = Nd4j.zeros(inputs);
        for (int i = 0; i < inputs; i++) {
            features.putScalar(new int[]{i}, something[i]);
        }
        double[] output = model.output(features).toDoubleVector();
        double highest = 0;
        int indexH = -1;
        for (int i = 0; i < output.length; i++) {
            if (output[i] > 0 && output[i] > highest) {
                highest = output[i];
                indexH = i;
            }
        }
        return indexH;

    }

}
