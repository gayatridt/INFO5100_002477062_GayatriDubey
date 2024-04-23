// University Asset System - Observer Design Pattern

import java.util.ArrayList;
import java.util.List;

// Subject: AssetManager
class AssetManager
{
    //region properties
    private List<MaintenanceStaff> lstMaintenanceStaff = new ArrayList<>();
    //endregion

    //region methods
    // Attach a maintenance staff member to the list of observers.
    public void attach(MaintenanceStaff staff)
    {
        lstMaintenanceStaff.add(staff);
    }

    // Detach a maintenance staff member from the list of observers.
    public void detach(MaintenanceStaff staff)
    {
        lstMaintenanceStaff.remove(staff);
    }

    //Notify all maintenance staff members of an update.
    public void notifyStaff()
    {
        for (MaintenanceStaff staff : lstMaintenanceStaff)
        {
            staff.update();
        }
    }
    //endregion
}