package calorimetry;

import java.math.BigDecimal;


public class Formulas {
    
    public double SpecificHeatFormula(double Mass, double DeltaTemp, double ThermalConductivity){
        BigDecimal MassB = new BigDecimal(Mass+"");
        BigDecimal DeltaTampB = new BigDecimal(DeltaTemp+"");
        BigDecimal ThermalConductivityB = new BigDecimal(ThermalConductivity+"");
        BigDecimal FinalAnswer = MassB.multiply(DeltaTampB.multiply(ThermalConductivityB));
        FinalAnswer = FinalAnswer.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        return FinalAnswer.doubleValue();
    }
    public double LatentHeatFormula(double Mass, double LatentHeat){
        BigDecimal MassB = new BigDecimal(Mass+"");
        BigDecimal LatentHeatB = new BigDecimal(LatentHeat+"");
        BigDecimal FinalAnswer = MassB.multiply(LatentHeatB);
        FinalAnswer = FinalAnswer.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        return FinalAnswer.doubleValue();
    }
    public double Problem$1Formula(double Mass, double DeltaTemp, double ThermalConductivity, double LatentHeat){
        BigDecimal NumeratorB = new BigDecimal(SpecificHeatFormula(Mass, DeltaTemp,ThermalConductivity) +"");
        BigDecimal LatentHeatB = new BigDecimal(LatentHeat+"");
        BigDecimal FinalAnswer = NumeratorB.divide(LatentHeatB,BigDecimal.ROUND_HALF_UP);
        
        return FinalAnswer.doubleValue();
    }
    public double Problem$2Formula(double Mass, double DeltaTemp, double ThermalConductivity, double Mass2, double DeltaTemp2, double ThermalConductivity2, double Mass3, double DeltaTemp3){
        double Numerator;
        BigDecimal NumeratorB,FinalAnswer,Mass3B,DeltaTemp3B,DenominatorB;
        Mass3B = new BigDecimal(Mass3+"");
        DeltaTemp3B = new BigDecimal(DeltaTemp3+"");
        DenominatorB = Mass3B.multiply(DeltaTemp3B);
        
        Numerator = SpecificHeatFormula(Mass,DeltaTemp,ThermalConductivity) + SpecificHeatFormula(Mass2,DeltaTemp2,ThermalConductivity2);
        NumeratorB = new BigDecimal(Numerator+"");
        FinalAnswer = NumeratorB.divide(DenominatorB,BigDecimal.ROUND_HALF_UP);
        
        return FinalAnswer.doubleValue();
    }
    public double MissingTemp_FirstTerm(double ThermalConductivity, double Mass){
        BigDecimal ThermalConductivityB = new BigDecimal(ThermalConductivity+"");
        BigDecimal MassB = new BigDecimal(Mass+"");
        BigDecimal AnswerB = MassB.multiply(ThermalConductivityB);
        AnswerB = AnswerB.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        return AnswerB.doubleValue();        
    }   
    public double MissingTemp_SecondTerm(double ThermalConductivity, double Mass, double TempInitial){
        BigDecimal SecondTerm,DecimalNumber,TempInitialB;
        double FirsTerm = MissingTemp_FirstTerm(ThermalConductivity,Mass),Tempinitial2 = (-1 * TempInitial);
        DecimalNumber = new BigDecimal(FirsTerm+"");
        TempInitialB = new BigDecimal(Tempinitial2+"");
        SecondTerm = DecimalNumber.multiply(TempInitialB);
        
        return SecondTerm.doubleValue();
    }
    public double Problem$3Formula(double Mass, double Thermal_1, double Latent,
                                   double deltaTemp,double Thermal_2, double Mass1, double Thermal_3,
                                   double Thermal_4, double Mass2, double BoilingPoint,
                                   double Tempinitial1, double Tempinitial2){
        double FirstLine,SecondLine,ThirdLineF,ThirdLineS,FourthLineF,FourthLineS,FifthLineF,FifthLineS;
        BigDecimal Constant,Denominator,FinalAnswer;
        
        FirstLine = SpecificHeatFormula(Mass,deltaTemp,Thermal_1);
        SecondLine = LatentHeatFormula(Mass,Latent);
        ThirdLineF = MissingTemp_FirstTerm(Thermal_2,Mass);
        ThirdLineS = MissingTemp_SecondTerm(Thermal_2,Mass,BoilingPoint);
        FourthLineF = MissingTemp_FirstTerm(Thermal_3,Mass1);
        FourthLineS = MissingTemp_SecondTerm(Thermal_3,Mass1,Tempinitial1);
        FifthLineF = MissingTemp_FirstTerm(Thermal_4,Mass2);
        FifthLineS = MissingTemp_SecondTerm(Thermal_4,Mass2,Tempinitial2);
        
        Constant = new BigDecimal(((FirstLine + SecondLine + ThirdLineS + FourthLineS + FifthLineS)*-1) + "");
        Denominator = new BigDecimal(((ThirdLineF + FourthLineF + FifthLineF)) + "");
        FinalAnswer = Constant.divide(Denominator, BigDecimal.ROUND_HALF_UP);
        
        return FinalAnswer.doubleValue();
    }
}