package businessentitiesapi;

/**
 * {@link Manager} interface for the {@link TicketOption} entity.
 */
public interface TicketOptionManager extends Manager<TicketOption, Integer> {

    TicketOption createTicketOption(String name, int price);

    TicketOption createTicketOption(Integer id, String name, int price);
}
