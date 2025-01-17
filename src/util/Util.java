package util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import model.Customer;

public class Util {

	public static String formatDateToString(Date date) {

		return date != null ? new SimpleDateFormat("dd/MM/yyyy").format(date) : "";
	}

	public static Customer copyInventoryAndServicePayment(Customer oldCustomer, Customer newCustomer) {

		// Inventory Unit First Section
		newCustomer.setContentUnitTable(oldCustomer.getContentUnitTable());
		newCustomer.setContentUnitChairs(oldCustomer.getContentUnitChairs());
		newCustomer.setContentUnitFridgeClean(oldCustomer.getContentUnitFridgeClean());
		newCustomer.setContentUnitCookerClean(oldCustomer.getContentUnitCookerClean());
		newCustomer.setContentUnitDoubleBed(oldCustomer.getContentUnitDoubleBed());
		newCustomer.setContentUnitDoubleMattress(oldCustomer.getContentUnitDoubleMattress());
		newCustomer.setContentUnitSingleBed(oldCustomer.getContentUnitSingleBed());
		newCustomer.setContentUnitSingleMattress(oldCustomer.getContentUnitSingleMattress());
		newCustomer.setContentUnitBunkBed(oldCustomer.getContentUnitBunkBed());
		newCustomer.setContentUnitWindowHandle(oldCustomer.getContentUnitWindowHandle());
		newCustomer.setContentUnitDrawerChest(oldCustomer.getContentUnitDrawerChest());

		// Inventory Condition First Section
		newCustomer.setContentConditionTable(oldCustomer.getContentConditionTable());
		newCustomer.setContentConditionChairs(oldCustomer.getContentConditionChairs());
		newCustomer.setContentConditionFridgeClean(oldCustomer.getContentConditionFridgeClean());
		newCustomer.setContentConditionCookerClean(oldCustomer.getContentConditionCookerClean());
		newCustomer.setContentConditionDoubleBed(oldCustomer.getContentConditionDoubleBed());
		newCustomer.setContentConditionDoubleMattress(oldCustomer.getContentConditionDoubleMattress());
		newCustomer.setContentConditionSingleBed(oldCustomer.getContentConditionSingleBed());
		newCustomer.setContentConditionSingleMattress(oldCustomer.getContentConditionSingleMattress());
		newCustomer.setContentConditionBunkBed(oldCustomer.getContentConditionBunkBed());
		newCustomer.setContentConditionWindowHandle(oldCustomer.getContentConditionWindowHandle());
		newCustomer.setContentConditionDrawerChest(oldCustomer.getContentConditionDrawerChest());

		// Inventory Unit Second Section
		newCustomer.setContentUnitWardrobe(oldCustomer.getContentUnitWardrobe());
		newCustomer.setContentUnitKeysPerPerson(oldCustomer.getContentUnitKeysPerPerson());
		newCustomer.setContentUnitLightBulb(oldCustomer.getContentUnitLightBulb());
		newCustomer.setContentUnitBathroomShowerDrain(oldCustomer.getContentUnitBathroomShowerDrain());
		newCustomer.setContentUnitBathroomSinkDrain(oldCustomer.getContentUnitBathroomSinkDrain());
		newCustomer.setContentUnitBathroomHeadHose(oldCustomer.getContentUnitBathroomHeadHose());
		newCustomer.setContentUnitBathroomToiletFlush(oldCustomer.getContentUnitBathroomToiletFlush());
		newCustomer.setContentUnitKitchenSinkDrain(oldCustomer.getContentUnitKitchenSinkDrain());
		newCustomer.setContentUnitWashingMachineClean(oldCustomer.getContentUnitWashingMachineClean());
		newCustomer.setContentUnitDryerMachineClean(oldCustomer.getContentUnitDryerMachineClean());

		// Inventory Unit Second Section
		newCustomer.setContentConditionWardrobe(oldCustomer.getContentConditionWardrobe());
		newCustomer.setContentConditionKeysPerPerson(oldCustomer.getContentConditionKeysPerPerson());
		newCustomer.setContentConditionLightBulb(oldCustomer.getContentConditionLightBulb());
		newCustomer.setContentConditionBathroomShowerDrain(oldCustomer.getContentConditionBathroomShowerDrain());
		newCustomer.setContentConditionBathroomSinkDrain(oldCustomer.getContentConditionBathroomSinkDrain());
		newCustomer.setContentConditionBathroomHeadHose(oldCustomer.getContentConditionBathroomHeadHose());
		newCustomer.setContentConditionBathroomToiletFlush(oldCustomer.getContentConditionBathroomToiletFlush());
		newCustomer.setContentConditionKitchenSinkDrain(oldCustomer.getContentConditionKitchenSinkDrain());
		newCustomer.setContentConditionWashingMachineClean(oldCustomer.getContentConditionWashingMachineClean());
		newCustomer.setContentConditionDryerMachineClean(oldCustomer.getContentConditionDryerMachineClean());
		
		
		

		
		// Service Payment to Land lord
		newCustomer.setSerPayCentralMonFriWhatsapp(oldCustomer.getSerPayCentralMonFriWhatsapp());
		newCustomer.setSerPaySetOfKeys(oldCustomer.getSerPaySetOfKeys());
		newCustomer.setSerPayEletricity(oldCustomer.getSerPayEletricity());
		newCustomer.setSerPayRentBook(oldCustomer.getSerPayRentBook());
		newCustomer.setSerPayInternetPhoneTV(oldCustomer.getSerPayInternetPhoneTV());
		newCustomer.setSerPayPainterPlumber(oldCustomer.getSerPayPainterPlumber());
		newCustomer.setSerPayGeneralWasteRecycling(oldCustomer.getSerPayGeneralWasteRecycling());
		newCustomer.setSerPayTransfServiceByCar(oldCustomer.getSerPayTransfServiceByCar());
		newCustomer.setSerPaySupplyEletricKettle(oldCustomer.getSerPaySupplyEletricKettle());
		newCustomer.setSerPaySpareFridgeCook(oldCustomer.getSerPaySpareFridgeCook());
		newCustomer.setSerPaySpareDoorLock(oldCustomer.getSerPaySpareDoorLock());
		newCustomer.setSerPayToiletSeat(oldCustomer.getSerPayToiletSeat());
		
		newCustomer.setExtraInformation(oldCustomer.getExtraInformation());

	

		return newCustomer;
	}

	public static InputStream createRentBook(InputStream templateStream, HashMap<String, String> variables) {

		/*try {

			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateStream);

			MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

			VariablePrepare.prepare(wordMLPackage);

			documentPart.variableReplace(variables);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			wordMLPackage.save(outputStream);

			InputStream download = new ByteArrayInputStream(outputStream.toByteArray());

			return download;

		} catch (Exception e) {

			e.printStackTrace();
		}*/
		return null;

	}

	public static HashMap<String, String> createRentBookAttributes(Customer customer) {
		HashMap<String, String> variables = new LinkedHashMap<String, String>();

		// Header
		variables.put("studioDetails",
				customer.getStudio().getAddress().getDescription() + " - " + customer.getStudio().getDescription());

		// Tenancy Details
		/*variables.put("name", Strings.nullToEmpty(customer.getName()));
		variables.put("email", Strings.nullToEmpty(customer.getEmail()));
		variables.put("dateOfBirth", Util.formatDateToString(customer.getDateOfBirth()));
		variables.put("placeOfBirth", Strings.nullToEmpty(customer.getPlaceOfBirth()));
		variables.put("nationality", Strings.nullToEmpty(customer.getNationality()));
		variables.put("passportnumber", Strings.nullToEmpty(customer.getPassportNumber()));
		variables.put("passportExpiryDate", Util.formatDateToString(customer.getPassportExpiryDate()));
		variables.put("phoneNumber", Strings.nullToEmpty(customer.getPhoneNumber()));
		variables.put("ppsNumber", Strings.nullToEmpty(customer.getPpsNumber()));
		variables.put("gnibNumber", Strings.nullToEmpty(customer.getGnibNumber()));
		variables.put("gnibExpiryDate", Util.formatDateToString(customer.getGnibExpiryDate()));
		variables.put("PRTBNumber", Strings.nullToEmpty(customer.getPRTBNumber()));
		variables.put("dateOfCommencent", Util.formatDateToString(customer.getDateOfCommencent()));
		variables.put("addressTenancy", Strings.nullToEmpty(customer.getAddressTenancy()));
		variables.put("rentDay", String.valueOf(customer.getRentDay()));
		variables.put("depositPaid", String.valueOf(customer.getDepositPaid()));
		variables.put("rentInAdvance", String.valueOf(customer.getRentInAdvance()));
		variables.put("fixedTermFromFormat", Strings.nullToEmpty(customer.getFixedTermFromFormat()));
		variables.put("term", Strings.nullToEmpty(customer.getTermOfTheTenancy()));
		variables.put("fixedTermToFormat", Strings.nullToEmpty(customer.getFixedTermToFormat()));

		// Tenancy Emergency Brazil
		variables.put("emerRg", Strings.nullToEmpty(customer.getEmergencyBrazilRg()));
		variables.put("emerCpf", Strings.nullToEmpty(customer.getEmergencBrazilCpf()));
		variables.put("emerFone", Strings.nullToEmpty(customer.getEmergencBrazilFone()));
		variables.put("emerEndereco", Strings.nullToEmpty(customer.getEmergencBrazilEndereco()));
		variables.put("emerBairro", Strings.nullToEmpty(customer.getEmergencBrazilBairro()));
		variables.put("emerComplemento", Strings.nullToEmpty(customer.getEmergencBrazilComplemento()));
		variables.put("emerCep", Strings.nullToEmpty(customer.getEmergencBrazilCep()));
		variables.put("emerCidade", Strings.nullToEmpty(customer.getEmergencBrazilCidade()));
		variables.put("emerEstado", Strings.nullToEmpty(customer.getEmergencBrazilEstado()));

		// Inventory Unit First Section
		variables.put("tblUnit", Strings.nullToEmpty(customer.getContentUnitTable()));
		variables.put("chaUnit", Strings.nullToEmpty(customer.getContentUnitChairs()));
		variables.put("fridUnit", Strings.nullToEmpty(customer.getContentUnitFridgeClean()));
		variables.put("cooUnit", Strings.nullToEmpty(customer.getContentUnitCookerClean()));
		variables.put("dbeUnit", Strings.nullToEmpty(customer.getContentUnitDoubleBed()));
		variables.put("dmUnit", Strings.nullToEmpty(customer.getContentUnitDoubleMattress()));
		variables.put("sbUnit", Strings.nullToEmpty(customer.getContentUnitSingleBed()));
		variables.put("smUnit", Strings.nullToEmpty(customer.getContentUnitSingleMattress()));
		variables.put("bdUnit", Strings.nullToEmpty(customer.getContentUnitBunkBed()));
		variables.put("whUnit", Strings.nullToEmpty(customer.getContentUnitWindowHandle()));
		variables.put("scUnit", Strings.nullToEmpty(customer.getContentUnitDrawerChest()));

		// Inventory Condition First Section
		variables.put("tblCond", Strings.nullToEmpty(customer.getContentConditionTable()));
		variables.put("chaCond", Strings.nullToEmpty(customer.getContentConditionChairs()));
		variables.put("fridCond", Strings.nullToEmpty(customer.getContentConditionFridgeClean()));
		variables.put("cooCond", Strings.nullToEmpty(customer.getContentConditionCookerClean()));
		variables.put("deCond", Strings.nullToEmpty(customer.getContentConditionDoubleBed()));
		variables.put("dmCond", Strings.nullToEmpty(customer.getContentConditionDoubleMattress()));
		variables.put("sbCond", Strings.nullToEmpty(customer.getContentConditionSingleBed()));
		variables.put("smCond", Strings.nullToEmpty(customer.getContentConditionSingleMattress()));
		variables.put("bdCond", Strings.nullToEmpty(customer.getContentConditionBunkBed()));
		variables.put("whCond", Strings.nullToEmpty(customer.getContentConditionWindowHandle()));
		variables.put("scCond", Strings.nullToEmpty(customer.getContentConditionDrawerChest()));

		// Inventory Unit Second Section
		variables.put("wcUnit", Strings.nullToEmpty(customer.getContentUnitWardrobe()));
		variables.put("kpUnit", Strings.nullToEmpty(customer.getContentUnitKeysPerPerson()));
		variables.put("lbUnit", Strings.nullToEmpty(customer.getContentUnitLightBulb()));
		variables.put("bsdUnit", Strings.nullToEmpty(customer.getContentUnitBathroomShowerDrain()));
		variables.put("bsiUnit", Strings.nullToEmpty(customer.getContentUnitBathroomSinkDrain()));
		variables.put("bshUnit", Strings.nullToEmpty(customer.getContentUnitBathroomHeadHose()));
		variables.put("btfUnit", Strings.nullToEmpty(customer.getContentUnitBathroomToiletFlush()));
		variables.put("ksdUnit", Strings.nullToEmpty(customer.getContentUnitKitchenSinkDrain()));
		variables.put("wmcUnit", Strings.nullToEmpty(customer.getContentUnitWashingMachineClean()));
		variables.put("dmcUnit", Strings.nullToEmpty(customer.getContentUnitDryerMachineClean()));

		// Inventory Cond Second Section
		variables.put("wcCond", Strings.nullToEmpty(customer.getContentConditionWardrobe()));
		variables.put("kpCond", Strings.nullToEmpty(customer.getContentConditionKeysPerPerson()));
		variables.put("lbCond", Strings.nullToEmpty(customer.getContentConditionLightBulb()));
		variables.put("bsdCond", Strings.nullToEmpty(customer.getContentConditionBathroomShowerDrain()));
		variables.put("bsiCond", Strings.nullToEmpty(customer.getContentConditionBathroomSinkDrain()));
		variables.put("bshCond", Strings.nullToEmpty(customer.getContentConditionBathroomHeadHose()));
		variables.put("btfCond", Strings.nullToEmpty(customer.getContentConditionBathroomToiletFlush()));
		variables.put("ksdCond", Strings.nullToEmpty(customer.getContentConditionKitchenSinkDrain()));
		variables.put("wmcCond", Strings.nullToEmpty(customer.getContentConditionWashingMachineClean()));
		variables.put("dmcCond", Strings.nullToEmpty(customer.getContentConditionDryerMachineClean()));
		
		
		// Inventory Cond Second Section
		variables.put("sp1", Strings.nullToEmpty(customer.getSerPayCentralMonFriWhatsapp()));
		variables.put("sp2", Strings.nullToEmpty(customer.getSerPaySetOfKeys()));
		variables.put("sp3", Strings.nullToEmpty(customer.getSerPayEletricity()));
		variables.put("sp4", Strings.nullToEmpty(customer.getSerPayRentBook()));
		variables.put("sp5", Strings.nullToEmpty(customer.getSerPayInternetPhoneTV()));
		variables.put("sp6", Strings.nullToEmpty(customer.getSerPayPainterPlumber()));
		variables.put("sp7", Strings.nullToEmpty(customer.getSerPayGeneralWasteRecycling()));
		variables.put("sp8", Strings.nullToEmpty(customer.getSerPayTransfServiceByCar()));
		variables.put("sp9", Strings.nullToEmpty(customer.getSerPaySupplyEletricKettle()));
		variables.put("sp10", Strings.nullToEmpty(customer.getSerPaySpareFridgeCook()));
		variables.put("sp11", Strings.nullToEmpty(customer.getSerPaySpareDoorLock()));
		variables.put("sp12", Strings.nullToEmpty(customer.getSerPayToiletSeat()));*/
		
		return variables;

	}

}
