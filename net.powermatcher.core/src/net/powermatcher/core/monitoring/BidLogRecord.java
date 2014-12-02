package net.powermatcher.core.monitoring;

import java.text.DateFormat;
import java.util.Date;

import net.powermatcher.api.data.Bid;
import net.powermatcher.api.data.MarketBasis;
import net.powermatcher.api.data.PricePoint;
import net.powermatcher.api.monitoring.BidEvent;

public class BidLogRecord extends LogRecord {

    private Bid bid;

    public BidLogRecord(BidEvent event, Date logTime, DateFormat dateFormat) {
        super(event.getClusterId(), event.getAgentId(), event.getQualifier(), logTime, event.getTimestamp(), dateFormat);

        this.bid = event.getBid();
    }

    @Override
    public String[] getLine() {
        MarketBasis marketBasis = bid.getMarketBasis();

        StringBuilder demandBuilder = new StringBuilder();
        StringBuilder pricePointBuiler = new StringBuilder();

        for (Double d : this.bid.getDemand()) {
            if (demandBuilder.length() > 0) {
                demandBuilder.append("#");
            }
            demandBuilder.append(d);
        }

        if (bid.getPricePoints() != null) {

            for (PricePoint p : this.bid.getPricePoints()) {
                if (pricePointBuiler.length() > 0) {
                    pricePointBuiler.append("|");
                }

                int priceStep = marketBasis.toPriceStep(p.getNormalizedPrice());
                pricePointBuiler.append(MarketBasis.PRICE_FORMAT.format(marketBasis.toPrice(priceStep)));
                pricePointBuiler.append("|").append(MarketBasis.DEMAND_FORMAT.format(p.getDemand()));
            }
        }

        return new String[] { getDateFormat().format(getLogTime()), getClusterId(), getAgentId(),
                getQualifier().getDescription(), marketBasis.getCommodity(), marketBasis.getCurrency(),
                MarketBasis.PRICE_FORMAT.format(marketBasis.getMinimumPrice()),
                MarketBasis.PRICE_FORMAT.format(marketBasis.getMaximumPrice()),
                MarketBasis.DEMAND_FORMAT.format(this.bid.getMinimumDemand()),
                MarketBasis.DEMAND_FORMAT.format(this.bid.getMaximumDemand()),
                // TODO where/what is the "effective demand"?
                MarketBasis.DEMAND_FORMAT.format(0),
                // TODO where/what is the "effective price"?
                MarketBasis.PRICE_FORMAT.format(0), getDateFormat().format(getEventTimestamp()),
                String.valueOf(this.bid.getBidNumber()), demandBuilder.toString(), pricePointBuiler.toString() };
    }
}